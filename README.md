<h1>Package Items Packer</h1>

<p>The task resolve the problem of packing the suitable items to be fit within a package having a weight limit. The target is to packing the optimal items to fit in the package with the most higher cost.</p>

<h2>Algorithm</h2>
<p>The task has been resolved using dynamic programming.</p>

<h2>Tech Stack</h2>
<ul>
  <li>Java 8</li>
  <li>Junit</li>
</ul>

<h2>Main Files Strucutre</h2>
<ul>
  <li>Models: we have two main entities (Item and PackageData)</li>
  <li>Services
    <ul>
        <li>PackageChallengeProcessor: is the main processor which handle the initial flow.</li>
        <li>PackageTargetItemsResolver: contains the logic to filter the package items and compare to fit the target items with the higher costs into package.</li>
    </ul>
  </li>
  <li>Util classes
    <ul>
        <li>PackageFileParser: The main file parser, it converts the file to list of PackageData containing the parsed list of items. And this call PackageDataParser.</li>
        <li>PackageDataParser: For every line read from PackageFileParser, it will parsed into PackageData and list of items inside.</li>
        <li>PackageDataValidator: the validator class to apply all constrains defined below
          <ol>
              <li>The maximum weight that a package can hold must be <= 100.</li>
              <li>There may be up to 15 items you can to choose from.</li>
              <li>The maximum weight of an item should be <= 100.</li>
              <li>The maximum cost of an item should be <= €100.</li>
          </ol>
        </li>
    </ul>
  </li>
  <li>All validations executed in the application throws BusinessException with different business messages.</li>
  <li>In order to execute the application, just there is a sample file under /resources/ folder and you can run MainEntry.java.</li>
</ul>








