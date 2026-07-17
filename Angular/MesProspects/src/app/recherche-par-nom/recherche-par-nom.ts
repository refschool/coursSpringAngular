import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Prospect } from '../model/prospect.model';
import { ProspectService } from '../services/prospect';
import { SearchFilterPipe } from '../search-filter-pipe';

@Component({
  selector: 'app-recherche-par-nom',
  imports: [FormsModule, CommonModule, SearchFilterPipe],
  templateUrl: './recherche-par-nom.html',
  styles: ``,
})
export class RechercheParNom implements OnInit {

  nomProspect: string = '';
  prospects!: Prospect[];
  allProspects!: Prospect[];
  searchTerm!: string;

  constructor(private prospectService: ProspectService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.prospectService.listeProspect().subscribe(prospects => {
      console.log(prospects);
      // this.allProspects = prospects;
      this.prospects = prospects;
    });


  }
  rechercherProspects() {
    if (this.nomProspect)
      //ou bien (this.nomProspect!=="")
      this.prospectService
        .rechercherParNom(this.nomProspect)
        .subscribe((prospects) => {
          console.log(prospects);
          this.prospects = prospects;
          this.cdr.detectChanges();
        });
    else
      this.prospectService.listeProspect().subscribe((prospects) => {
        console.log(prospects);
        this.prospects = prospects;
        this.cdr.detectChanges();
      });

  };
  onKeyUp(filterText: string) {
    this.prospects = this.allProspects.filter(item =>
      item.nom!.toLowerCase().includes(filterText));
  }

};



