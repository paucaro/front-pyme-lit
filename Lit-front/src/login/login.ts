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
          <div class="container" style="background-color:#FFFFFF">
            <div class="text-center">
              <img src="../images/bbva.png" class="img-fluid" />
              <div class="font-weight-normal" style="color:#043263">
                <h4>#FinanciamientoATuMedida</h4>
              </div>
              <p>
                <em
                  ><small
                    >Completa los siguientes datos para continuar</small
                  ></em
                >
              </p>
            </div>
            <div
              class="font-weight-normal"
              style="margin-left:50px; color:#043263"
            >
              <br />
              <h6>DNI</h6>
            </div>
            <div class="col-auto" style="margin-left:32px">
              <div class="input-group mb-2">
                <div class="input-group-prepend" style="opacity:0.5">
                  <img src="../images/bxs-user.svg" />
                </div>
                <input
                  type="text"
                  class="form-control"
                  id="inlineFormInputGroup"
                  placeholder="Documento de Identidad"
                />
              </div>
            </div>
            <div
              class="font-weight-normal"
              style="margin-left:50px; color:#043263"
            >
              <br />
              <h6>RUC</h6>
            </div>
            <div class="col-auto" style="margin-left:32px">
              <div class="input-group mb-2">
                <div class="input-group-prepend" style="opacity:0.5">
                  <img src="../images/bxs-building.svg" />
                </div>
                <input
                  type="text"
                  class="form-control"
                  id="inlineFormInputGroup"
                  placeholder="RUC Empresa"
                />
              </div>
            </div>
            <div
              class="font-weight-normal"
              style="margin-left:50px; color:#043263"
            >
              <br />
              <h6>Facturación anual (en Millones)</h6>
            </div>
            <div class="form-group" style="margin-left:50px">
              <div class="input-group mb-2">
                <div class="input-group-prepend" style="opacity:0.5">
                  <img src="../images/bx-money.svg" />
                </div>
                <select class="custom-select" required>
                  <option value="">Elija una opción</option>
                  <option value="1">0 - 0.36</option>
                  <option value="2">0.36 - 1</option>
                  <option value="3">1 - 3</option>
                  <option value="3">3 - 8</option>
                  <option value="3">8 - más</option>
                </select>
              </div>
            </div>
            <br />
            <div class="text-center">
              <button type="button" class="btn btn-primary">Pre-Evaluar</button>
            </div>

            <h6 style="margin-left:50px">
              <em><small>Esta es una pagina segura del BBVA</small></em>
            </h6>
          </div>
        </div>
        <div class="col-sm-8">
          <div style="position: relative;">
            <div style="position: absolute;">
              <img
                src="../images/inicio.png"
                class="img-fluid"
                alt="Responsive image"
                style="width:100%"
              />
            </div>
            <div style="position: absolute; left: 200px; top: 250px;">
              <div class="text-white">
                <div class="text-center">
                  <h1 class="font-weight-bold">Evalúa tu préstamo</h1>
                  <p></p>
                  <p class="font-weight-bold" style="letter-spacing: 5pt">
                    Encuentra el mejor financiamiento para tí!
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    `;
  }
}
