import { Component } from '@angular/core';

@Component({
  selector: 'app-binding',
  imports: [],
  templateUrl: './binding.html',
  styles: ``,
})
export class Binding {
  titre: String = "Demo Interpolation";
  status: boolean = false;
  changerTitre() {
    this.titre = "Nouveau Titre";
  }
}
