import { Component, Input, OnInit } from '@angular/core';
import { Commercial } from '../model/commercial.model';

@Component({
  selector: 'app-update-commercial',
  imports: [],
  templateUrl: './update-commercial.html',
  styles: ``,
})
export class UpdateCommercial implements OnInit {
  @Input()
  commercial!: Commercial;
  constructor() { }
  ngOnInit(): void {
  }
}
