import { Injectable } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommercialWrapper } from '../model/CommercialWrapped.model';
import { Auth } from './auth';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProspectService {

  apiURL: string = 'http://localhost:8080/utilisateur/api/prospects';
  commercialURL: string = 'http://localhost:8080/utilisateur/commercial';
  apiURL2: string = 'http://localhost:8080/utilisateur/api/commercials';

  constructor(private http: HttpClient, private authService: Auth) {
  }
  listeProspect(): Observable<Prospect[]> {

    return this.http.get<Prospect[]>(this.apiURL);
  }
  ajouterProspect(prospect: Prospect): Observable<Prospect> {

    return this.http.post<Prospect>(this.apiURL, prospect);
  }
  supprimerProspect(id: number) {
    const url = `${this.apiURL}/${id}`;

    return this.http.delete(url);
  }
  consulterProspect(id: number): Observable<Prospect> {
    const url = `${this.apiURL}/${id}`;

    return this.http.get<Prospect>(url);
  }
  updateProspect(prospect: Prospect): Observable<Prospect> {

    return this.http.put<Prospect>(
      this.apiURL,
      prospect
    );
  }

  listeCommerciaux(): Observable<Commercial[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });

    return this.http
      .get<CommercialWrapper>(this.commercialURL, { headers: httpHeaders })
      .pipe(
        map(wrapper => wrapper._embedded?.commercials || [])
      );
  }

  rechercherParCommercial(idCommercial: number): Observable<Prospect[]> {
    const url = `${this.apiURL}/by-commercial`;
    let jwt = this.authService.getToken();
    jwt = "Bearer " + jwt;
    let httpHeaders = new HttpHeaders({ "Authorization": jwt })
    return this.http.post<Prospect[]>(url, { idCommercial }, { headers: httpHeaders });
  }
  rechercherParNom(nom: string): Observable<Prospect[]> {
    const url = `${this.apiURL}/prospectsByName/${nom}`;
    return this.http.get<Prospect[]>(url);
  }
  ajouterCommercial(commercial: Commercial): Observable<Commercial> {
    const url = `${this.apiURL2}/addcommercial`;
    return this.http.post<Commercial>(url, commercial, httpOptions);
  }


}
