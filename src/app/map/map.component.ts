import { Component, OnInit, ViewChild, ElementRef, AfterViewInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, AfterViewInit {
  @ViewChild('mapOverlay', { static: true }) mapOverlay!: ElementRef<SVGElement>;
  @Output() locationSelected = new EventEmitter<string>();
  selectedArea: SVGElement | null = null;

  ngOnInit() {}

  ngAfterViewInit() {
    this.initializeMap();
  }

  initializeMap() {
    const svg = this.mapOverlay.nativeElement as unknown as SVGSVGElement;
    const tooltip = svg.querySelector('#tooltip');
    const tooltipText = svg.querySelector('#tooltip-text');

    if (!tooltip || !tooltipText) {
      console.error('Tooltip elements not found');
      return;
    }

    svg.addEventListener('mousemove', (event: MouseEvent) => {
      const pt = svg.createSVGPoint();
      pt.x = event.clientX;
      pt.y = event.clientY;
      const svgP = pt.matrixTransform(svg.getScreenCTM()!.inverse());
      tooltip.setAttribute('transform', `translate(${svgP.x + 10}, ${svgP.y + 10})`);
    });

    const areas = svg.querySelectorAll('.map-area');
    areas.forEach((area) => {
      area.addEventListener('mouseenter', (event) => {
        const target = event.target as SVGElement;
        const areaName = target.getAttribute('data-name');
        if (tooltipText instanceof SVGTextElement && areaName) {
          tooltipText.textContent = areaName;
          tooltip.setAttribute('visibility', 'visible');
        }
      });

      area.addEventListener('mouseleave', () => {
        tooltip.setAttribute('visibility', 'hidden');
      });
    });
  }

  onAreaClick(areaName: string, event: MouseEvent) {
    if (this.selectedArea) {
      this.selectedArea.classList.remove('selected');
    }

    const clickedArea = event.target as SVGElement;
    clickedArea.classList.add('selected');
    this.selectedArea = clickedArea;

    this.locationSelected.emit(areaName);
  }



}
