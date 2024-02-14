let books = [];

function addBook() {
    const bookName = document.getElementById('bookName').value;
    const authorName = document.getElementById('authorName').value;
    const bookDescription = document.getElementById('bookDescription').value;
    const pagesNumber = parseInt(document.getElementById('pagesNumber').value);
    if (bookName && authorName && bookDescription && !isNaN(pagesNumber)) {
        const book = {
            name: bookName,
            authorName: authorName,
            bookDescription: bookDescription,
            pagesNumber: pagesNumber
        };
        books.push(book);
        showbooks();
        clearInputs();
    } else {
        alert('Please fill in all fields correctly.');
    }
}

function removeBook(){
    const bookNameToRemove = document.getElementById("bookNameToRemove").value;
    const indexToRemove = books.findIndex(book => book.name === bookNameToRemove);
    if (indexToRemove != -1){
        books.splice(indexToRemove, 1);
        showbooks();
    }
    return indexToRemove != -1;
}

function updateBookByName() {
    const bookNameToUpdate = document.getElementById('bookNameToUpdate').value;
    const newBookName = document.getElementById('newBookName').value;
    const newAuthorName = document.getElementById('newAuthorName').value;
    const newBookDescription = document.getElementById('newBookDescription').value;
    const newPagesNumber = parseInt(document.getElementById('newPagesNumber').value);
    if (newBookName && newAuthorName && newBookDescription && !isNaN(newPagesNumber)) {
        const newBook = {
            name: newBookName,
            authorName: newAuthorName,
            bookDescription: newBookDescription,
            pagesNumber: newPagesNumber
        };
        const index = books.findIndex(book => book.name === bookNameToUpdate);
        if (index !== -1) {
            books.splice(index, 1, newBook);
            showbooks();
            alert('Book updated.');
            return;
        }
    }
}

function showbooks() {
    const booksDiv = books.map((book, index) => `
        <h1>Book Number: ${index + 1}</h1>
        <p><strong>Book Name: </strong>${book.name}</p>
        <p><strong>Author Name:</strong> ${book.authorName}</p>
        <p><strong>Book Description:</strong> ${book.bookDescription}</p>
        <p><strong>No. of Pages:</strong> ${book.pagesNumber} mins</p>
    `).join(''); // Use join to concatenate the array into a single string

    document.getElementById('books').innerHTML = booksDiv;
}

function clearInputs() {
    document.getElementById('bookName').value = '';
    document.getElementById('authorName').value = '';
    document.getElementById('bookDescription').value = '';
    document.getElementById('pagesNumber').value = '';
}
