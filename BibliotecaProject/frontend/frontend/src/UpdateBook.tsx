import React, { useState } from 'react';

const UpdateBook: React.FC = () => {
    const [bookId, setBookId] = useState<number | string>('');
    const [book, setBook] = useState({
        title: '',
        author: '',
        genre: '',
        isbn: '',
        language: '',
        publisher: '',
        publishedDate: ''
    });
    const [responseMessage, setResponseMessage] = useState('');

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setBook({
            ...book,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async () => {
        const res = await fetch(`http://localhost:8080/book/update/${bookId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(book),
        });

        const data = await res.json();
        setResponseMessage(data.message);
    };

    return (
        <div>
            <h1>Aggiorna Libro</h1>
            <input type="number" placeholder="ID Libro" value={bookId} onChange={(e) => setBookId(e.target.value)} />
            <input type="text" name="title" placeholder="Titolo" onChange={handleChange} />
            <input type="text" name="author" placeholder="Autore" onChange={handleChange} />
            <input type="text" name="genre" placeholder="Genere" onChange={handleChange} />
            <input type="text" name="isbn" placeholder="ISBN" onChange={handleChange} />
            <input type="text" name="language" placeholder="Lingua" onChange={handleChange} />
            <input type="text" name="publisher" placeholder="Editore" onChange={handleChange} />
            <input type="date" name="publishedDate" onChange={handleChange} />
            <button onClick={handleSubmit}>Aggiorna Libro</button>
            <p>{responseMessage}</p>
        </div>
    );
};

export default UpdateBook;
