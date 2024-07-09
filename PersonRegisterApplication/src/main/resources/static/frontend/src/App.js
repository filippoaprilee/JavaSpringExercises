import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
    const [persons, setPersons] = useState([]);
    const [newPerson, setNewPerson] = useState({ firstName: '', lastName: '', email: '' });

    useEffect(() => {
        axios.get('http://localhost:8080/api/persons')
            .then(response => {
                console.log('Data from API:', response.data);
                setPersons(response.data);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewPerson(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/persons', newPerson)
            .then(response => {
                setPersons(persons.concat(response.data));
                setNewPerson({ firstName: '', lastName: '', email: '' }); // Reset form
            })
            .catch(error => console.error('Error adding person:', error));
    };

    return (
        <div>
            <h1>Person Register</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="firstName"
                    value={newPerson.firstName}
                    onChange={handleInputChange}
                    placeholder="First Name"
                    required
                />
                <input
                    type="text"
                    name="lastName"
                    value={newPerson.lastName}
                    onChange={handleInputChange}
                    placeholder="Last Name"
                    required
                />
                <input
                    type="email"
                    name="email"
                    value={newPerson.email}
                    onChange={handleInputChange}
                    placeholder="Email"
                    required
                />
                <button type="submit">Add Person</button>
            </form>
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