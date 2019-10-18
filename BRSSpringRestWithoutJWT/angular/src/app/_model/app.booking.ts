import { Passenger } from '../_model/app.passenger';
import { Bus } from './app.bus';

export class Booking{
    bookingId: number;
    bookingStatus: string;
    modeOfPayment: string;
    bus: Bus;
    passengers: Passenger[];
    totalCost: number;
    dateOfJourney: any;
    deleteFlag: number;
}