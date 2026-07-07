import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-binding',
  imports: [FormsModule],
  templateUrl: './binding.html',
  styles: ``,
})
export class Binding {
  titre: String = "Demo Interpolation";
  status: boolean = false;
  changerTitre() {
    this.titre = "Nouveau Titre";
  }
  nom: String = "Yvon Huynh";
}
