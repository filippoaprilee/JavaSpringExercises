import React, { useState } from 'react';
import { BookingDTO } from '../types/BookingDTO';

const BookingForm: React.FC<{ onCreate: (booking: BookingDTO) => void }> = ({ onCreate }) => {
    const [guestName, setGuestName] = useState('');
    const [roomNumber, setRoomNumber] = useState(0);
    const [checkInDate, setCheckInDate] = useState('');
    const [checkOutDate, setCheckOutDate] = useState('');
    const [totalPrice, setTotalPrice] = useState(0);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const newBooking: BookingDTO = {
            id: 0, // L'id sarà generato dal backend
            guestName,
            roomNumber,
            checkInDate,
            checkOutDate,
            totalPrice,
        };

        const response = await fetch('http://127.0.0.1:8080/bookings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newBooking),
        });

        if (response.ok) {
            const createdBooking = await response.json();
            onCreate(createdBooking);
            // Resetta il modulo dopo la creazione
            setGuestName('');
            setRoomNumber(0);
            setCheckInDate('');
            setCheckOutDate('');
            setTotalPrice(0);
        } else {
            console.error('Errore nella creazione della prenotazione');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Nome Ospite" value={guestName} onChange={(e) => setGuestName(e.target.value)} required />
            <input type="number" placeholder="Numero Stanza" value={roomNumber} onChange={(e) => setRoomNumber(Number(e.target.value))} required />
            <input type="date" placeholder="Data Check-In" value={checkInDate} onChange={(e) => setCheckInDate(e.target.value)} required />
            <input type="date" placeholder="Data Check-Out" value={checkOutDate} onChange={(e) => setCheckOutDate(e.target.value)} required />
            <input type="number" placeholder="Prezzo Totale" value={totalPrice} onChange={(e) => setTotalPrice(Number(e.target.value))} required />
            <button type="submit">Crea Prenotazione</button>
        </form>
    );
};

export default BookingForm;
