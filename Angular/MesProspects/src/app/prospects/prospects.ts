import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';
import { Auth } from '../services/auth';

@Component({
  selector: 'app-prospects',
  imports: [CommonModule],
  templateUrl: './prospects.html'
})
export class Prospects implements OnInit {

  prospects: Prospect[] = [];
  commercial: Commercial[] = [];

  constructor(
    private prospectService: ProspectService,
    private cdr: ChangeDetectorRef,
    private router: Router,
    public authService: Auth
  ) { }

  ngOnInit(): void {
    this.chargerProspects();
    this.chargerCommerciaux();
  }

  trackByProspectId(index: number, prospect: Prospect): number {
    return prospect.idProspect;
  }

  chargerProspects(): void {
    this.prospectService.listeProspect().subscribe(prospects => {
      this.prospects = prospects;
      this.cdr.detectChanges();
    });
  }

  chargerCommerciaux(): void {
    this.prospectService.listeCommerciaux().subscribe(commercial => {
      this.commercial = commercial;
      this.cdr.detectChanges();
    });
  }

  naviguerVersModification(prospect: Prospect): void {
    this.router.navigate(['/updateProspect', prospect.idProspect]);
  }

  supprimerProspect(prospect: Prospect): void {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce prospect ?")) {
      this.prospectService.supprimerProspect(prospect.idProspect)
        .subscribe(() => this.chargerProspects());
    }
  }

}