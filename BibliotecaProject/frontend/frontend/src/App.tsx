import React, { useState } from 'react';
import CreateBook from './CreateBook';
import DeleteBook from './DeleteBook';
import UpdateBook from './UpdateBook';
import FindBook from './FindBook';
import FindAllBooks from './FindAllBooks';

const App: React.FC = () => {
    const [page, setPage] = useState<string>('home');

    const renderPage = () => {
        switch (page) {
            case 'create-book':
                return <CreateBook />;
            case 'delete-book':
                return <DeleteBook />;
            case 'update-book':
                return <UpdateBook />;
            case 'find-book':
                return <FindBook />;
            case 'find-all-books':
                return <FindAllBooks />;
            default:
                return (
                    <div>
                        <h1>Benvenuto nel sistema di gestione libri</h1>
                        <button onClick={() => setPage('create-book')}>Crea Libro</button>
                        <button onClick={() => setPage('delete-book')}>Elimina Libro</button>
                        <button onClick={() => setPage('update-book')}>Aggiorna Libro</button>
                        <button onClick={() => setPage('find-book')}>Trova Libro</button>
                        <button onClick={() => setPage('find-all-books')}>Tutti i Libri</button>
                    </div>
                );
        }
    };

    return (
        <div>
            {renderPage()}
        </div>
    );
};

export default App;
