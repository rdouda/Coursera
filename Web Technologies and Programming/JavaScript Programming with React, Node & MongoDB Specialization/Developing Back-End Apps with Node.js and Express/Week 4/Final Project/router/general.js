const express = require('express');
let books = require("./booksdb.js");
let isValid = require("./auth_users.js").isValid;
let users = require("./auth_users.js").users;
const public_users = express.Router();

public_users.post("/register", (req, res) => {
  const { username, password } = req.body;

  if (!username || !password) {
    return res.status(400).json({ message: "Username and password are required" });
  }

  if (!isValid(username)) {
    return res.status(400).json({ message: "Invalid username format" });
  }

  if (users.some(user => user.username === username)) {
    return res.status(409).json({ message: "Username already exists" });
  }

  users.push({ username, password });
  return res.status(201).json({ message: "Registration successful" });
});

// Get the book list available in the shop
public_users.get('/', function (req, res) {
  return res.status(200).json(Object.values(books));
});

// Get book details based on ISBN
public_users.get('/isbn/:isbn', function (req, res) {
  const isbn = parseInt(req.params.isbn);
  const book = books[isbn];

  if (book) {
    return res.status(200).json(book);
  } else {
    return res.status(404).json({ message: "Book not found" });
  }
});

// Get book details based on author
public_users.get('/author/:author', function (req, res) {
  const author = req.params.author;
  const authorBooks = Object.values(books).filter(book => book.author === author);

  if (authorBooks.length > 0) {
    return res.status(200).json(authorBooks);
  } else {
    return res.status(404).json({ message: "Books by the author not found" });
  }
});

// Get all books based on title
public_users.get('/title/:title', function (req, res) {
  const title = req.params.title.toLowerCase();
  const titleBooks = Object.values(books).filter(book => book.title.toLowerCase().includes(title));

  if (titleBooks.length > 0) {
    return res.status(200).json(titleBooks);
  } else {
    return res.status(404).json({ message: "Books with the title not found" });
  }
});

// Get book review
public_users.get('/review/:isbn', function (req, res) {
  const isbn = parseInt(req.params.isbn);
  const book = books[isbn];

  if (book && Object.keys(book.reviews).length > 0) {
    return res.status(200).json(book.reviews);
  } else {
    return res.status(404).json({ message: "Reviews for the book not found" });
  }
});

module.exports.general = public_users;
