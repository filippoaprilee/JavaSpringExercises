// BookingList.tsx
import React from 'react';
import { BookingDTO } from '../types/BookingDTO'; // Assicurati che il percorso sia corretto

interface BookingListProps {
    bookings: BookingDTO[]; // Assicurati che la tipizzazione corrisponda al tuo DTO
}

const BookingList: React.FC<BookingListProps> = ({ bookings }) => {
    return (
        <div>
            <h2>Lista di Prenotazioni</h2>
            <ul>
                {bookings.map((booking) => (
                    <li key={booking.id}>
                        <h3>{booking.guestName}</h3>
                        <p>Camera: {booking.roomNumber}</p>
                        <p>Check-in: {booking.checkInDate}</p>
                        <p>Check-out: {booking.checkOutDate}</p>
                        <p>Prezzo Totale: {booking.totalPrice}€</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BookingList;
