import { Routes } from '@angular/router';
import { Prospects } from './prospects/prospects';
import { AddProspect } from './add-prospect/add-prospect';


export const routes: Routes = [
    { path: "prospects", component: Prospects },
    { path: "add-prospect", component: AddProspect },
    { path: "", redirectTo: "prospects", pathMatch: "full" }
];
