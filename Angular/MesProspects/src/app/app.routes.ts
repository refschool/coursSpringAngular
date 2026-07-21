import { Routes } from '@angular/router';
import { Prospects } from './prospects/prospects';
import { AddProspect } from './add-prospect/add-prospect';
import { UpdateProspect } from './update-prospect/update-prospect';
import { RechercheParCommercial } from './recherche-par-commercial/recherche-par-commercial';
import { RechercheParNom } from './recherche-par-nom/recherche-par-nom';
import { ListeCommercial } from './liste-commercial/liste-commercial';
import { Login } from './login/login';

export const routes: Routes = [
    { path: "prospects", component: Prospects },
    { path: "add-prospect", component: AddProspect },
    { path: "", redirectTo: "prospects", pathMatch: "full" },
    { path: "updateProspect/:id", component: UpdateProspect },
    { path: "rechercheParCommercial", component: RechercheParCommercial },
    { path: "rechercheParNom", component: RechercheParNom },
    { path: "listeCommerciaux", component: ListeCommercial },
    { path: 'login', component: Login },
]; 
