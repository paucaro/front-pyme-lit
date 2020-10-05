import { LitElement, html, customElement, css } from 'lit-element';
import { bootstrapStyles } from '../../external/granite-lit-bootstrap';

@customElement('lit-login')
export class Login extends LitElement {
  static get styles() {
    return [bootstrapStyles];
  }

  render() {
    return html`
      <div class="row">
        <div class="col-sm-4">
          <div class="container">
            <img src="../images/bbva.png" class="img-fluid" />
            <h4 class="text-primary">#FinanciamientoATuMedida</h4>
            <p>
              <em
                ><small>Completa los siguientes datos para continuar</small></em
              >
            </p>
            <button type="button" class="btn btn-primary">Pre-Evaluar</button>
          </div>
        </div>
        <div class="col-sm-8">
          <img
            src="../images/inicio.png"
            class="img-fluid"
            alt="Responsive image"
          />
        </div>
      </div>
    `;
  }
}
