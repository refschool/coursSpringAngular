import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-liste-commercial',
  imports: [CommonModule],
  templateUrl: './liste-commercial.html',
  styles: ``,
})
export class ListeCommercial implements OnInit {
  commercial!: Commercial[];
  constructor(private prospectService: ProspectService,
    private cdr: ChangeDetectorRef) { }
  ngOnInit(): void {
    this.prospectService.listeCommerciaux().
      subscribe(commercial => {
        this.commercial = commercial;
        console.log(commercial);
        this.cdr.detectChanges();
      });
  }
}

