import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Commercial } from '../model/commercial.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-commercial',
  imports: [FormsModule],
  templateUrl: './update-commercial.html',
  styles: ``,
})
export class UpdateCommercial implements OnInit {
  @Input()
  commercial!: Commercial;
  @Input()
  ajout!: boolean;
  @Output()
  commercialUpdated = new EventEmitter<Commercial>();


  constructor() { }

  ngOnInit(): void {
    console.log("ngOnInit du composant UpdateCommercial ", this.commercial);
  }

  saveCommercial() {
    this.commercialUpdated.emit(this.commercial);
  }
}

