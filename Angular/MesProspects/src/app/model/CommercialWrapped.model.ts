import { Commercial } from './commercial.model';
export class CommercialWrapper {
    _embedded!: { commercials: Commercial[] };
}