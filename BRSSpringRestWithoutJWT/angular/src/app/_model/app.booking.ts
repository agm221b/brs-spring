import { Passenger } from '../_model/app.passenger';
import { Bus } from './app.bus';
import { User } from './app.user';

export class Booking{
    bookingId: number;
    bookingStatus: string;
    modeOfPayment: string;
    bus: Bus;
    user: User;
    passengers: Passenger[];
    totalCost: number;
    dateOfJourney: any;
    deleteFlag: number;
}