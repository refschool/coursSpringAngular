import { Component, OnInit } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProspectService } from '../services/prospect';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Commercial } from '../model/commercial.model';

@Component({
  selector: 'app-update-prospect',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-prospect.html',
  styles: ``
})
export class UpdateProspect implements OnInit {

  currentProspect = new Prospect();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private prospectService: ProspectService
  ) { }

  commercial!: Commercial[];
  updatedCommercialId!: number;

  ngOnInit(): void {
    this.commercial = this.prospectService.listeCommerciaux();

    this.currentProspect =
      this.prospectService.consulterProspect(
        this.activatedRoute.snapshot.params['id']
      );

    this.updatedCommercialId =
      this.currentProspect.commercial!.id_commercial!;
  }
  updateProspect() {
    this.currentProspect.commercial =
      this.prospectService.consulterCommercial(Number(this.updatedCommercialId));

    console.log(this.currentProspect);

    this.prospectService.updateProspect(this.currentProspect);

    this.router.navigate(['prospects']);
  }

}
