import React, { useState } from 'react';
import BookingForm from './components/BookingForm';
import BookingList from './components/BookingList';
import { BookingDTO } from './types/BookingDTO';

const App: React.FC = () => {
    const [bookings, setBookings] = useState<BookingDTO[]>([]);

    const handleCreateBooking = (booking: BookingDTO) => {
        setBookings((prev) => [...prev, booking]);
    };

    return (
        <div>
            <h1>Gestione Prenotazioni Hotel</h1>
            <BookingForm onCreate={handleCreateBooking} />
            <BookingList bookings={bookings} />
        </div>
    );
};

export default App;
