import { Injectable } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';

@Injectable({
  providedIn: 'root'
})
export class ProspectService {

  prospects: Prospect[];
  commercial: Commercial[];

  constructor() {
    console.log("Service New");
    this.commercial = [
      {
        id_commercial: 1,
        nom: "Dupont",
        prenom: "Pierre",
        email: "pierre.dupont@example.com",
        telephone: "06 12 34 56 78",
        date_embauche: new Date("2023-02-15")
      },
      {
        id_commercial: 2,
        nom: "Lefevre",
        prenom: "Sophie",
        email: "sophie.lefevre@example.com",
        telephone: "07 98 76 54 32",
        date_embauche: new Date("2024-06-10")
      }
    ];
    this.prospects = [
      {
        id_prospect: 1,
        nom: "Durand",
        prenom: "Alice",
        email: "alice.durand@example.com",
        telephone: "06 45 23 89 12",
        entreprise: "TechNova",
        source: "LinkedIn",
        date_creation: new Date("2025-11-12"),
        commercial: {
          id_commercial: 1,
          nom: "Dupont",
          prenom: "Pierre",
          email: "pierre.dupont@example.com",
          telephone: "06 12 34 56 78",
          date_embauche: new Date("2023-02-15")
        }
      },
      {
        id_prospect: 2,
        nom: "Martin",
        prenom: "Lucas",
        email: "lucas.martin@example.com",
        telephone: "07 81 22 45 90",
        entreprise: "GreenSoft",
        source: "Salon professionnel",
        date_creation: new Date("2025-10-03"),
        commercial: {
          id_commercial: 2,
          nom: "Lefevre",
          prenom: "Sophie",
          email: "sophie.lefevre@example.com",
          telephone: "07 98 76 54 32",
          date_embauche: new Date("2024-06-10")
        }
      }
    ];
  }

  listeProspects(): Prospect[] {
    return this.prospects;
  }

  ajouterProspect(prospect: Prospect) {
    this.prospects.push(prospect);
  }
  supprimerProspect(pro: Prospect) {
    const index = this.prospects.indexOf(pro, 0);
    if (index > -1) {
      this.prospects.splice(index, 1);
    }
  }
  prospect!: Prospect;
  consulterProspect(id: number): Prospect {
    this.prospect = this.prospects.find(p => p.id_prospect == id)!;
    return this.prospect;
  }
  updateProspect(prospect: Prospect) {

    const index = this.prospects.indexOf(prospect, 0);

    if (index > -1) {
      this.prospects.splice(index, 1);      // supprimer l'ancien élément
      this.prospects.splice(index, 0, prospect); // insérer le nouvel élément
    }
  }
}
