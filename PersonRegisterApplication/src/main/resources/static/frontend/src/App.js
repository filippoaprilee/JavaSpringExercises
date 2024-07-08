import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
    const [persons, setPersons] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/persons')
            .then(response => {
                console.log('Data from API:', response.data);
                setPersons(response.data);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div>
            <h1>Person Register</h1>
            <ul>
                {persons.map(person => (
                    <li key={person.id}>
                        {person.firstName} {person.lastName} - {person.email}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
