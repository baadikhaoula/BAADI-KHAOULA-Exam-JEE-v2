import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CustomerService } from '../../../services/customer.service';
import { AuthService } from '../../../services/auth.service';
import { Customer } from '../../../models/customer';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './customer-list.component.html',
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  keyword = '';

  constructor(
    public customerService: CustomerService,
    public authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getAll().subscribe((data) => (this.customers = data));
  }

  search(): void {
    if (this.keyword.trim()) {
      this.customerService.search(this.keyword).subscribe((data) => (this.customers = data));
    } else {
      this.loadCustomers();
    }
  }

  delete(id: number): void {
    if (confirm('Confirmer la suppression ?')) {
      this.customerService.delete(id).subscribe(() => this.loadCustomers());
    }
  }
}
