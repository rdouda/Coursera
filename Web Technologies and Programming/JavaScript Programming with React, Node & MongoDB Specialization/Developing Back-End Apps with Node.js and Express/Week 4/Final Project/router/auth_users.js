const express = require('express');
const jwt = require('jsonwebtoken');
let books = require("./booksdb.js");
const regd_users = express.Router();

let users = [];

const isValid = (username, password) => {
  if (!username || !password) {
    return "Username and password are required";
  }

  const existingUser = users.find(user => user.username === username);
  if (existingUser) {
    return "Username already exists";
  }
  return null;
}

const authenticatedUser = (username, password) => {
  const user = users.find(u => u.username === username && u.password === password);
  return !!user;
}

// Only registered users can login
regd_users.post("/login", (req, res) => {
  const { username, password } = req.body;

  if (authenticatedUser(username, password)) {
    const token = jwt.sign({ username }, 'dec571c507a0cfcafbdd5a529fc1028c98da1a8b3d70a04e7ec91b703ea4f54a', { expiresIn: '1h' });
    return res.status(200).json({ message: "Login successful", token });
  } else {
    return res.status(401).json({ message: "Invalid username or password" });
  }
});

// Add a book review
regd_users.put("/auth/review/:isbn", (req, res) => {
  const { isbn } = req.params;
  const { review } = req.body;
  const user = req.user;

  if (!user) {
    return res.status(401).json({ message: "Unauthorized - User not authenticated" });
  }

  if (!review) {
    return res.status(400).json({ message: "Review text is required in the query parameters" });
  }

  if (!books[isbn]) {
    return res.status(404).json({ message: "Book not found" });
  }

  // Check if the user has already posted a review for the given ISBN
  if (books[isbn].reviews.hasOwnProperty(user.username)) {
    // If the user already posted a review, modify the existing one
    books[isbn].reviews[user.username] = review;
    return res.status(200).json({ message: "Review modified successfully" });
  } else {
    // If it's a new review for the ISBN, add it to the reviews
    books[isbn].reviews[user.username] = review;
    return res.status(201).json({ message: "Review added successfully" });
  }
});

// Delete a book review
regd_users.delete("/auth/review/:isbn", (req, res) => {
  const { isbn } = req.params;
  const user = req.user;

  if (!user) {
    return res.status(401).json({ message: "Unauthorized - User not authenticated" });
  }

  if (!books[isbn]) {
    return res.status(404).json({ message: "Book not found" });
  }

  // Check if the user has posted a review for the given ISBN
  if (books[isbn].reviews.hasOwnProperty(user.username)) {
    // If the user has posted a review, delete it
    delete books[isbn].reviews[user.username];
    return res.status(200).json({ message: "Review deleted successfully" });
  } else {
    return res.status(404).json({ message: "Review not found" });
  }
});


module.exports.authenticated = regd_users;
module.exports.isValid = isValid;
module.exports.users = users;
