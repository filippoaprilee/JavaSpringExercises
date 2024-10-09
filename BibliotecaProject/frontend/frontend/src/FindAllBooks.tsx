import React, { useState, useEffect } from 'react';

const FindAllBooks: React.FC = () => {
    const [books, setBooks] = useState<any[]>([]);

    useEffect(() => {
        const fetchBooks = async () => {
            const res = await fetch('http://localhost:8080/book/all', {
                method: 'GET',
            });
            const data = await res.json();
            setBooks(data.data);
        };

        fetchBooks();
    }, []);

    return (
        <div>
            <h1>Tutti i Libri</h1>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>
                        <strong>{book.title}</strong> - {book.author}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FindAllBooks;
