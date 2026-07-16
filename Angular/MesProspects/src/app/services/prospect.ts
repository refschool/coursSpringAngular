import { Injectable } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommercialWrapper } from '../model/CommercialWrapped.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProspectService {

  apiURL: string = 'http://localhost:8080/utilisateur/api/prospects';
  commercialURL: string = 'http://localhost:8080/utilisateur/commercial';

  constructor(private http: HttpClient) {
  }
  listeProspect(): Observable<Prospect[]> {
    return this.http.get<Prospect[]>(this.apiURL);
  }
  ajouterProspect(prospect: Prospect): Observable<Prospect> {
    return this.http.post<Prospect>(this.apiURL, prospect, httpOptions);
  }
  supprimerProspect(id: number): Observable<void> {
    const url = `${this.apiURL}/${id}`;

    return this.http.delete<void>(url, httpOptions);
  }
  consulterProspect(id: number): Observable<Prospect> {
    const url = `${this.apiURL}/${id}`;

    return this.http.get<Prospect>(url);
  }
  updateProspect(prospect: Prospect): Observable<Prospect> {
    return this.http.put<Prospect>(
      this.apiURL,
      prospect,
      httpOptions
    );
  }

  listeCommerciaux(): Observable<Commercial[]> {
    return this.http.get<CommercialWrapper>(this.commercialURL)
      .pipe(map(wrapper => wrapper._embedded?.commercials || []));
  }

}
