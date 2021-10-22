import { AppService } from './app.service';
import { Component, ViewChild } from '@angular/core';
import { App } from './app';

import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProjectTools';

  agenda: App = {
   country: '',
   state: '',
   countrycode: '',
   number: '',
   name: ''
  }

  displayedColumns: string[] = ['country', 'state', 'countrycode', 'number', 'name'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort)
  sort!: MatSort;

  agendas: App[] = [];

  constructor(private service: AppService){

    const Tools = Array.from({length: 100}, (_, k) => createNewUser(k + 1));

    this.dataSource = new MatTableDataSource(Tools);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }


  ngOnInit(): void{
    this.service.findAll()
    .subscribe(resposta=>this.dataSource.data = resposta);

  }

  applyFilter(event: Event) {
     const filterValue = (event.target as HTMLInputElement).value;
     this.dataSource.filter = filterValue.trim().toLowerCase();
    this.dataSource.filter = filterValue;

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}

function createNewUser(id: number): App {
  return {
    country: Math.round(Math.random() * 100).toString(),
    state: Math.round(Math.random() * 100).toString(),
    countrycode: Math.round(Math.random() * 100).toString(),
    number: Math.round(Math.random() * 100).toString(),
    name: Math.round(Math.random() * 100).toString()
  };
}
