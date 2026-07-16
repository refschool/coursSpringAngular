import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';

@Component({
  selector: 'app-add-prospect',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-prospect.html',
  styleUrl: './add-prospect.css'
})
export class AddProspect implements OnInit {

  newProspect = new Prospect();
  commercial: Commercial[] = [];
  newIdCommercial!: number;

  message = "";

  constructor(
    private prospectService: ProspectService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.prospectService.listeCommerciaux().
      subscribe(commercials => {
        this.commercial = commercials;
      }
      );
  }

  addProspect(): void {

    this.newProspect.commercial = {
      idCommercial: this.newIdCommercial
    } as Commercial;

    this.prospectService.ajouterProspect(this.newProspect)
      .subscribe(() => {
        this.message = "Prospect ajouté avec succès !";
        this.router.navigate(['prospects']);
      });

  }

}