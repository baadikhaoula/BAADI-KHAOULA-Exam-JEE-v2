import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
})
export class LoginComponent {
  username = '';
  password = '';
  error = '';

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {}

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: (data) => {
        this.authService.saveToken(data.token);
        this.authService.saveUsername(data.username);
        this.router.navigate(['/dashboard']);
      },
      error: () => {
        this.error = 'Identifiants incorrects !';
      },
    });
  }
}
