import {Component, Input, OnInit} from '@angular/core';
import { LocationService } from '../services/location.service';
import { LocationDTO } from '../models/locationDTO';
import { GameVersion } from '../models/game-version.enum';
import { TimeOfEncounter } from '../models/time-of-encounter.enum';
import { EncounterMethod } from '../models/encounter-method.enum';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit {

  locations: LocationDTO[] = [];
  defaultMethods: Set<EncounterMethod> = new Set([EncounterMethod.WALKING, EncounterMethod.SURFING]);
  allMethods = Object.values(EncounterMethod);
  currentVersion: GameVersion = GameVersion.HG;
  currentTimeOfEncounter: TimeOfEncounter = TimeOfEncounter.MORNING;
  currentLocationId: number = 10;

  constructor(private locationService: LocationService) {}

  ngOnInit(): void {
    this.loadEncounters();
  }

  loadEncounters(): void {
    this.locationService.getEncountersByMethodsVersionAndTime(this.currentLocationId, Array.from(this.defaultMethods), this.currentVersion, this.currentTimeOfEncounter).subscribe({
      next: (data: LocationDTO[]) => this.locations = data,
      error: (error: any) => console.error('Failed to fetch data:', error)
    });
  }


  toggleMethod(method: EncounterMethod): void {
    if (this.defaultMethods.has(method)) {
      this.defaultMethods.delete(method);
    } else {
      this.defaultMethods.add(method);
    }
    if (this.defaultMethods.size === 0) {
      this.defaultMethods.add(EncounterMethod.WALKING);
    }
    this.loadEncounters();
  }

  toggleVersion(): void {
    this.currentVersion = this.currentVersion === GameVersion.HG ? GameVersion.SS : GameVersion.HG;
    this.loadEncounters();
  }

  toggleTimeOfEncounter(): void {
    this.currentTimeOfEncounter = this.currentTimeOfEncounter === TimeOfEncounter.DAY ? TimeOfEncounter.NIGHT : TimeOfEncounter.DAY;
    this.loadEncounters();
  }

  setTimeOfEncounter(time: TimeOfEncounter): void {
    this.currentTimeOfEncounter = time;
    this.loadEncounters();
  }

  formatEncounterMethods(methods: string[]): string {
    return methods.map(method => {
      return method.split('_')
        .map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase())
        .join(' ');
    }).join(', ');
  }


  getVersionImage(version: GameVersion | null): string {
    if (version === GameVersion.HG) {
      return 'assets/versions/heartgold.png';
    } else if (version === GameVersion.SS) {
      return 'assets/versions/soulsilver.png';
    }
    return this.currentVersion === GameVersion.HG ? 'assets/versions/heartgold.png' : 'assets/versions/soulsilver.png';
  }

  getTimeImage(time: TimeOfEncounter | null): string {
    if (time === TimeOfEncounter.MORNING) {
      return 'assets/timeOfDay/morning-icon.png';
    } else if (time === TimeOfEncounter.DAY) {
      return 'assets/timeOfDay/day-icon.png';
    } else if (time === TimeOfEncounter.NIGHT) {
      return 'assets/timeOfDay/night-icon.png';
    }
    return `assets/timeOfDay/${this.currentTimeOfEncounter.toLowerCase()}-icon.png`;
  }

  getVersionString(versions: GameVersion[]): GameVersion | null {
    return versions.includes(this.currentVersion) ? this.currentVersion : null;
  }

  getTimeString(times: TimeOfEncounter[]): TimeOfEncounter | null {
    return times.includes(this.currentTimeOfEncounter) ? this.currentTimeOfEncounter : null;
  }

  formatEncounterMethod(method: string): string {
    return method.split('_').map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase()).join(' ');
  }

  hasSubLevels(): boolean {
    return this.locations.some(location => location.encounters.some(encounter => encounter.subLevel != null && encounter.subLevel.trim() !== ''));
  }


  protected readonly EncounterMethod = EncounterMethod;
  protected readonly GameVersion = GameVersion;
  protected readonly TimeOfEncounter = TimeOfEncounter;
  protected readonly Array = Array;
}
