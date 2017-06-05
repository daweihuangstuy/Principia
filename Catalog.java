public class Catalog {   

    private TopicTree treeTopics = constructTree();

    public Catalog() {
    }

    public TopicTree constructTree() {
	TopicTree _0 = new TopicTree("root");

        TopicTree _00 = new TopicTree("0 Kinematics");
        TopicTree _01 = new TopicTree("1 Forces");
        TopicTree _02 = new TopicTree("2 Energy and Power");
        TopicTree _03 = new TopicTree("3 Momentum");
        TopicTree _04 = new TopicTree("4 Sound Waves");
        TopicTree _05 = new TopicTree("5 Fluids");
        TopicTree _06 = new TopicTree("6 Thermodynamics");
        TopicTree _07 = new TopicTree("7 Electromagnetism");
        TopicTree _08 = new TopicTree("8 Optics");
        TopicTree _09 = new TopicTree("9 Quantum and Nuclear");
        _0.addChildren(_00, _01, _02, _03, _04,
                        _05, _06, _07, _08, _09);

        TopicTree _000 = new TopicTree("0 Displacement");
        TopicTree _001 = new TopicTree("1 Velocity");
        TopicTree _002 = new TopicTree("2 Acceleration");
        _00.addChildren(_000, _001, _002);

        TopicTree _010 = new TopicTree("0 Weight");
        TopicTree _011 = new TopicTree("1 Spring");
        TopicTree _012 = new TopicTree("2 Friction");
	TopicTree _013 = new TopicTree("3 Centripetal");
        _01.addChildren(_010, _011, _012, _013);
	   
        TopicTree _020 = new TopicTree("0 Work");
        TopicTree _021 = new TopicTree("1 Kinetic Energy");
        TopicTree _022 = new TopicTree("2 Potential Energy");
	TopicTree _023 = new TopicTree("3 Torque");
	TopicTree _024 = new TopicTree("4 Power");
        _02.addChildren(_020, _021, _022, _023, _024);
        
	TopicTree _030 = new TopicTree("0 Linear Momentum");
	TopicTree _031 = new TopicTree("1 Angular Momentum");
	TopicTree _032 = new TopicTree("2 Collisions");
	_03.addChildren(_030, _031, _032);

	TopicTree _040 = new TopicTree("0 Velocity");
	TopicTree _041 = new TopicTree("1 Sound Intensity");
	TopicTree _042 = new TopicTree("2 Doppler Effect");
	TopicTree _043 = new TopicTree("3 Beat Frequency");
	_04.addChildren(_040, _041, _042, _043);

	TopicTree _050 = new TopicTree("0 Density");
	TopicTree _051 = new TopicTree("1 Pressure");
	TopicTree _052 = new TopicTree("2 Fluid Exit Speed");
	TopicTree _053 = new TopicTree("3 Viscosity");
	_05.addChildren(_050, _051, _052, _053);

	TopicTree _060 = new TopicTree("0 Thermal Expansion");
	TopicTree _061 = new TopicTree("1 Specific Heat");
	TopicTree _062 = new TopicTree("2 Conduction");
	_06.addChildren(_060, _061, _062, _063);

	TopicTree _070 = new TopicTree("0 Electrostatics");
	TopicTree _071 = new TopicTree("1 Magnetostatics");
	TopicTree _072 = new TopicTree("2 Electrodynamics");
	TopicTree _073 = new TopicTree("3 Currents");
	_07.addChildren(_070, _071, _072, _073);

	TopicTree _080 = new TopicTree("0 Electromagnetic Spectrum");
	TopicTree _081 = new TopicTree("1 Refraction");
	TopicTree _082 = new TopicTree("2 Magnefication");
	TopicTree _083 = new TopicTree("3 Diffraction");
	TopicTree _084 = new TopicTree("4 Spherical Mirrors");
	_08.addChildren(_080, _081, _082, _083, _084);

	TopicTree _090 = new TopicTree("0 Relativity");
	TopicTree _091 = new TopicTree("1 Photons");
	TopicTree _092 = new TopicTree("2 Line Spectra");
	TopicTree _093 = new TopicTree("3 Radioactivity");
	_09.addChildren(_090, _091, _092, _093);

	return _0;
    }
    
    public TopicTree getTree() {
	return treeTopics;
    }
    
}
