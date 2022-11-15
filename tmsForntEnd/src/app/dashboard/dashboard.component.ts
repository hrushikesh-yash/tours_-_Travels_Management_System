import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertService } from '../Services/alert-service.service';
interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  cartProductCount: number = 10;
  constructor(private route: ActivatedRoute,
    private router: Router,

    private alertService: AlertService) { }

  ngOnInit(): void {
  }

  isSideNavCollapsed = false;
  screenWidth = 0;

  onToggleSideNav(data: SideNavToggle): void {
    this.screenWidth = data.screenWidth;
    // console.log(this.screenWidth);
    this.isSideNavCollapsed = data.collapsed;
    // console.log(this.isSideNavCollapsed);
  }

  logout() {
    this.alertService.success('Logout Sucessfully !', { keepAfterRouteChange: true });
    this.router.navigate(['../'], { relativeTo: this.route });
    localStorage.clear();
  }

  test()
  {
    // this.router.navigate(['/package'], { relativeTo: this.route });
    // this.router.navigate(['../'], { relativeTo: this.route });
  }

}
