import { Component, OnInit } from '@angular/core';
import { LocationDTO } from './models/locationDTO';
import { LocationService } from './services/location.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  selectedLocation: LocationDTO | LocationDTO[] | null = null;

  constructor(private locationService: LocationService) {}

  ngOnInit() {
    this.loadLocation(46);
  }

  loadLocation(locationId: number) {
    this.locationService.getLocationById(locationId).subscribe({
      next: (location: LocationDTO | LocationDTO[]) => {
        this.selectedLocation = location;
      },
    });
  }
}
