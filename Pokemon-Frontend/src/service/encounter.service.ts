import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { EncounterDTO } from '/Users/anthonylam/Desktop/Projects/PokemonAPI/Pokemon-Frontend/src/app/model/encounterDTO'

@Injectable({
  providedIn: 'root'
})
export class EncounterService {
  private apiUrl = 'http://localhost:8080/pokemon/encounters';

  constructor(private http: HttpClient) { }

  getEncounters(): Observable<EncounterDTO[]> {
    return this.http.get<EncounterDTO[]>(this.apiUrl);
  }
}
