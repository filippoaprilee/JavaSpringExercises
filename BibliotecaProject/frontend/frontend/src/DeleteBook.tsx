import React, { useState } from 'react';

const DeleteBook: React.FC = () => {
    const [bookId, setBookId] = useState<number | string>('');
    const [responseMessage, setResponseMessage] = useState('');

    const handleDelete = async () => {
        const res = await fetch(`http://localhost:8080/book/delete/${bookId}`, {
            method: 'DELETE',
        });

        const data = await res.json();
        setResponseMessage(data.message);
    };

    return (
        <div>
            <h1>Elimina Libro</h1>
            <input type="number" placeholder="ID Libro" value={bookId} onChange={(e) => setBookId(e.target.value)} />
            <button onClick={handleDelete}>Elimina</button>
            <p>{responseMessage}</p>
        </div>
    );
};

export default DeleteBook;
