<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css" />

    <!-- Custom font -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap"
      rel="stylesheet"
    />
    <title>Registration Form</title>
  </head>
  <body>
    <!-- Header -->
    <div
      class="d-flex flex-column flex-md-row align-items-center p-3 mb-3 bg-white border-bottom mx-5"
    >
      <h3 class="my-0 mr-md-auto text-teal">TO THE NEW</h3>
      <nav class="my-2 my-md-0 mt-3 font-weight-bold ">
        <a class="p-2 text-teal" href="index.jsp">Home</a>
      </nav>
    </div>

    <!-- Form -->
    <div class="row justify-content-center mb-5">
      <div class="col col-md-4 col-sm-10 mx-4">
        <div class="card card-outline-secondary">
          <div class="card-header bg-grey py-2">
            <h3 class="font-weight-bold text-white mt-3">Registration</h3>
          </div>

          <form class="form" method="POST" action="registration">

            <div class="card-body">

              <div class="form-group">
                <label for="email">Email:*</label>
                <input
                  class="form-control validate"
                  required="required"
                  type="text"
                  name="email"
                />
              </div>
              <div class="form-group">
                  <label for="username">Username:*</label>
                  <input
                    class="form-control"
                    required="required"
                    type="text"
                    name="username"
                  />
               </div>

              <div class="form-group">
                  <label for="password">Password:*</label>
                  <input
                    class="form-control"
                    required="required"
                    type="password"
                    name="password"
                  />
               </div>
            </div>

            <div class="card-footer py-1 pt-3">

              <div class="form-group row">
                <div class="col-md-12">
                  <button
                    class="btn float-right bg-teal text-white"
                    type="submit"
                  >
                    Submit
                  </button>
                </div>
              </div>

            </div>

          </form>
        </div>
      </div>
    </div>

    <script src="js/jquery.js"></script>
    <script src="js/poppin.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>