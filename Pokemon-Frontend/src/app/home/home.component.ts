import { Component, OnInit } from '@angular/core';
import { LocationDTO } from "../model/locationDTO";
import { LocationService } from "/Users/anthonylam/Desktop/Projects/PokemonAPI/Pokemon-Frontend/src/service/location.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  locations: LocationDTO[] = [];
  sproutTower: LocationDTO | undefined;

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.getLocations();
  }

  getLocations(): void {
    this.locationService.getLocations().subscribe((locations: LocationDTO[]) => {
      this.locations = locations;
      this.sproutTower = this.locations.find(location => location.name === 'Sprout Tower');
      console.log(this.sproutTower);  // Log the specific location to verify data
    });
  }
}
