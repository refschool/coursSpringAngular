import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Prospect } from '../model/prospect.model';


@Component({
  selector: 'app-prospects',
  imports: [CommonModule],
  templateUrl: './prospects.html'
})
export class Prospects {
  prospects: Prospect[];
  constructor() {
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
      }]
  }
}
