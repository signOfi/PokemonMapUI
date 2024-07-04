import { Component, OnInit } from '@angular/core';
import { LocationDTO } from './models/locationDTO';
import { LocationService } from './services/location.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  selectedLocation: LocationDTO | null = null;

  constructor(private locationService: LocationService) {}

  ngOnInit() {
    this.loadLocation(14);
  }

  onLocationSelected(locationName: string): void {
    this.locationService.getLocationByName(locationName).subscribe({
      next: (location: LocationDTO) => {
        this.selectedLocation = location;
      },
      error: (err) => {
        console.error('Error fetching location:', err);
      }
    });
  }

  loadLocation(locationId: number) {
    this.locationService.getLocationById(locationId).subscribe({
      next: (location: LocationDTO) => {
        this.selectedLocation = location;
      },
      error: (err) => {
        console.error('Error fetching location:', err);
      }
    });
  }
}
