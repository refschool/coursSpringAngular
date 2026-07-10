import { Injectable } from '@angular/core';
import { Prospect } from '../model/prospect.model';

@Injectable({
  providedIn: 'root'
})
export class ProspectService {

  prospects: Prospect[];

  constructor() {
    console.log("Service New");
    this.prospects = [
      {
        id_prospect: 1,
        nom: "Durand",
        prenom: "Alice",
        email: "alice.durand@example.com",
        telephone: "06 45 23 89 12",
        entreprise: "TechNova",
        source: "LinkedIn",
        date_creation: new Date("2025-11-12")
      },
      {
        id_prospect: 2,
        nom: "Martin",
        prenom: "Lucas",
        email: "lucas.martin@example.com",
        telephone: "07 81 22 45 90",
        entreprise: "GreenSoft",
        source: "Salon professionnel",
        date_creation: new Date("2025-10-03")
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
}
