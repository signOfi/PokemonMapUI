import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocationDTO } from '../models/locationDTO';
import { GameVersion } from '../models/game-version.enum';
import { TimeOfEncounter } from '../models/time-of-encounter.enum';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private apiUrl = '/api/pokemon';

  constructor(private http: HttpClient) { }

  getLocationById(locationId: number): Observable<LocationDTO> {
    return this.http.get<LocationDTO>(`${this.apiUrl}/encounters/${locationId}`);
  }

  getLocationByName(name: string): Observable<LocationDTO> {
    return this.http.get<LocationDTO>(`${this.apiUrl}/getLocationDTO/${name}`);
  }

  getEncountersByMethodsVersionAndTime(locationId: number, methods: string[], version: GameVersion, time: TimeOfEncounter): Observable<LocationDTO[]> {
    let params = new HttpParams()
      .set('encounterMethods', methods.join(','))
      .set('version', version)
      .set('requestedTime', time);

    return this.http.get<LocationDTO[]>(`${this.apiUrl}/encounters/${locationId}`, { params });
  }
}
