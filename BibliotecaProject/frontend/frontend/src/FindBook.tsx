import React, { useState } from 'react';

const FindBook: React.FC = () => {
    const [bookId, setBookId] = useState<number | string>('');
    const [book, setBook] = useState<any>(null);
    const [responseMessage, setResponseMessage] = useState('');

    const handleSearch = async () => {
        const res = await fetch(`http://localhost:8080/book/find/${bookId}`, {
            method: 'GET',
        });

        const data = await res.json();
        if (data.data) {
            setBook(data.data);
        } else {
            setResponseMessage(data.message);
        }
    };

    return (
        <div>
            <h1>Cerca Libro</h1>
            <input type="number" placeholder="ID Libro" value={bookId} onChange={(e) => setBookId(e.target.value)} />
            <button onClick={handleSearch}>Cerca</button>
            {book ? (
                <div>
                    <h2>Dettagli del Libro:</h2>
                    <p>Titolo: {book.title}</p>
                    <p>Autore: {book.author}</p>
                    {/* Visualizza gli altri campi */}
                </div>
            ) : (
                <p>{responseMessage}</p>
            )}
        </div>
    );
};

export default FindBook;
