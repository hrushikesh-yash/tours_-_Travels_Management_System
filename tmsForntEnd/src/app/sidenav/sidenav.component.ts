import { trigger, transition, style, animate, keyframes } from '@angular/animations';
import { Component, EventEmitter, HostListener, OnInit, Output } from '@angular/core';
import { User } from '../modules/masterUser';
import { UserService } from '../Services/UserService.service';
import { navbarData } from './nav-data';
interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('350ms',
          style({ opacity: 1 })
        )
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('350ms',
          style({ opacity: 0 })
        )
      ])
    ]),
    trigger('rotate', [
      transition(':enter', [
        animate('1000ms',
          keyframes([
            style({ transform: 'rotate(0deg)', offset: '0' }),
            style({ transform: 'rotate(2turn)', offset: '1' })
          ])
        )
      ])
    ])
  ]
})

export class SidenavComponent implements OnInit {

  currentUser: User;
  firstName: string = "";
  @Output() onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();
  collapsed = false;
  screenWidth = 0;
  navData = navbarData;

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.screenWidth = window.innerWidth;
    if (this.screenWidth <= 800) {
      this.collapsed = false;
      this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
    }
  }

  constructor(private userService: UserService) {
    // this.currentUser=this.userService.getLoginUser();
    
    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
    // console.log(this.currentUser.firstName);
    
    
    
  }


  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
    if(this.currentUser.actorId==2)
    {
      this.navData=this.navData.filter(navlist => navlist.routeLink !== 'State')
      this.navData=this.navData.filter(navlist => navlist.routeLink !== 'Vehicle-Type')
      this.navData=this.navData.filter(navlist => navlist.routeLink !== 'Vehicle-Driver-Assign')
      this.navData=this.navData.filter(navlist => navlist.routeLink !== 'Report')
     
    }
  }

  toggleCollapse(): void {
    this.collapsed = !this.collapsed;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }

  closeSidenav(): void {
    this.collapsed = false;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }

}
