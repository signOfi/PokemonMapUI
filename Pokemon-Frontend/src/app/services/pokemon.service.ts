import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import {LocationDTO} from '../models/locationDTO'

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private apiUrl = 'http://localhost:8080/pokemon';

  constructor(private http: HttpClient) { }

  getLocationById(locationId: number): Observable<LocationDTO> {
    return this.http.get<LocationDTO>(`${this.apiUrl}/getLocationDTO/${locationId}`);
  }

  getEncountersByMethodAndTime(locationId: number, method?: string, timesOfEncounter?: string[]): Observable<LocationDTO[]> {
    let params = new HttpParams();
    if (method) {
      params = params.append('encounterMethod', method);
    }
    if (timesOfEncounter && timesOfEncounter.length) {
      timesOfEncounter.forEach((time) => {
        params = params.append('timesOfEncounter', time);
      });
    }

    return this.http.get<LocationDTO[]>(`${this.apiUrl}/encounters/${locationId}`, { params });
  }

}
