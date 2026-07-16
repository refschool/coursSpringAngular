import { Commercial } from "./commercial.model";

export class Prospect {
    idProspect!: number;
    nom?: string;
    prenom?: string;
    email?: string;
    telephone?: string;
    entreprise?: string;
    source?: string;
    dateCreation?: Date;
    commercial?: Commercial;
}
