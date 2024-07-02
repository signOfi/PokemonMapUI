import { Component } from '@angular/core';
import { LocationDTO } from './models/locationDTO';
import { LocationService } from './services/location.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedLocation: LocationDTO | null = null;

  constructor(private locationService: LocationService) {}

  onLocationSelected(locationId: number) {
    this.locationService.getLocationById(locationId).subscribe(
      (location: LocationDTO) => {
        this.selectedLocation = location;
      }
    );
  }
}
