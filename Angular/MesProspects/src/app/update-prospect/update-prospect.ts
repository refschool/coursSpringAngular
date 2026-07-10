import { Component, OnInit } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProspectService } from '../services/prospect';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

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

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params['id'];
    this.currentProspect = this.prospectService.consulterProspect(id);
    console.log(this.currentProspect);
  }
  updateProspect() {
    this.prospectService.updateProspect(this.currentProspect);
    this.router.navigate(['prospects']);

  }

}
