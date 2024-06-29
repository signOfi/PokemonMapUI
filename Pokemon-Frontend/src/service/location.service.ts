import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { LocationDTO } from '/Users/anthonylam/Desktop/Projects/PokemonAPI/Pokemon-Frontend/src/app/model/locationDTO'

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiUrl = 'http://localhost:8080/api/pokemon/locations';

  constructor(private http: HttpClient) { }

  getLocations(): Observable<LocationDTO[]> {
    return this.http.get<LocationDTO[]>(this.apiUrl);
  }
}
