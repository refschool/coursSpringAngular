import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';

@Component({
  selector: 'app-update-prospect',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-prospect.html',
  styles: ``
})
export class UpdateProspect implements OnInit {

  currentProspect = new Prospect();
  commercial: Commercial[] = [];
  updatedCommercialId!: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private prospectService: ProspectService
  ) { }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.params['id']);

    this.prospectService.listeCommerciaux().subscribe(commercial => {
      this.commercial = commercial;
      this.chargerProspect(id);
    });
  }

  chargerProspect(id: number): void {
    this.prospectService.consulterProspect(id).subscribe(prospect => {
      this.currentProspect = prospect;
      this.updatedCommercialId = prospect.commercial?.idCommercial!;
    });
  }

  updateProspect(): void {

    this.currentProspect.commercial = {
      idCommercial: this.updatedCommercialId
    } as Commercial;

    this.prospectService.updateProspect(this.currentProspect)
      .subscribe(() => this.router.navigate(['prospects']));
  }

}